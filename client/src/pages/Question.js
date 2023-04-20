import { useRef, useState } from "react";
import { useParams } from "react-router-dom";

import useAxios from "../services/useAxios";
import { axiosDelete, axiosPatch } from "../services/api";

import StyledQuestionContainer from "../styles/StyledQuestionContainer";
import StyledList from "../styles/StyledList";
import StyledAnswer from "../styles/StyledAnswer";
import { MarkDown } from "../components/Input";
import StyledInputForm from "../styles/StyledInputForm";
import MarkdownViewer from "../components/MarkDownViewer";

function Question() {
  const devUrl = process.env.REACT_APP_DEV_URL;
  const { id } = useParams();
  const [question, , answers] = useAxios(`${devUrl}/questions/${id}`);
  // answers 도 useaxios로 받아오기

  // const [localAnswers, setLocalAnswers] = useState(question.answer || []);

  const handleDelete = () => {
    axiosDelete(`${devUrl}/questions/${id}`);
  };

  // markdown editor 사용
  const [bodyValue, setBodyValue] = useState("");

  // answer submit
  // url이 안바뀌니까 answer가 추가되어도 다시 데이터를 불러오지 않는다.
  const handleSubmit = (e) => {
    e.preventDefault();
    const newAnswer = { body: bodyValue };
    const data = {
      id: question.id,
      title: question.title,
      body: question.body,
      details: question.details,
      answers: [...answers, newAnswer],
    };

    axiosPatch(`${devUrl}/questions/${id}`, data, id);
    // 리렌더링
    // setLocalAnswers((prev) => [...prev, newAnswer]);
    setBodyValue("");
  };

  const editorAnswerRef = useRef();

  return (
    <StyledQuestionContainer>
      <StyledList>
        <h2>{question.title}</h2>
        <MarkdownViewer content={question.body} />
        <MarkdownViewer content={question.details} />
        <button type="button" onClick={handleDelete}>
          delete
        </button>
      </StyledList>

      <StyledAnswer>
        {!answers
          ? null
          : answers.map((el) => {
              return (
                <StyledList>
                  <MarkdownViewer key={el.id} content={el.body} />
                </StyledList>
              );
            })}
      </StyledAnswer>
      <StyledInputForm onSubmit={handleSubmit}>
        <MarkDown editorRef={editorAnswerRef} />
        <button type="submit">submit</button>
      </StyledInputForm>
    </StyledQuestionContainer>
  );
}

export default Question;
