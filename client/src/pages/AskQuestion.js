import { useState, useRef } from "react";
import useAxios from "../services/useAxios";

import useInput from "../services/useInput";
import { axiosCreate } from "../services/api";
import { Input, MarkDown, TextArea } from "../components/Input";
import StyledInputForm from "../styles/StyledInputForm";

function AskQuestion() {
  const titleBind = useInput("");
  // const bodyBind = useInput("");
  // const detailsBind = useInput("");

  // markdown editor 사용
  // const [bodyValue, setBodyValue] = useState("");
  // const [detailsValue, setDetailsValue] = useState("");

  // markdown editor 사용
  const editorBodyRef = useRef();
  const editorDetailsRef = useRef();

  const devUrl = process.env.REACT_APP_DEV_URL;

  const handleSubmit = (e) => {
    e.preventDefault();
    const bodyValue = editorBodyRef.current?.getInstance().getHTML();
    const detailsValue = editorDetailsRef.current?.getInstance().getHTML();
    const data = {
      title: titleBind.curValue,
      body: bodyValue,
      details: detailsValue,
      answers: [],
    };
    axiosCreate(`${devUrl}/questions`, data);
  };

  // markdown editor 사용
  // const bodyEditorBind = {
  //   value: bodyValue,
  //   onChange: setBodyValue,
  // };
  // markdown editor 사용
  // const detailsEditorBind = {
  //   value: detailsValue,
  //   onChange: setDetailsValue,
  // };

  return (
    <StyledInputForm onSubmit={handleSubmit}>
      <h2>Title</h2>
      <Input value={titleBind} onChange={titleBind.onChange} />
      <h2>What are the details of your problem?</h2>
      {/* <TextArea value={bodyBind} onChange={bodyBind.onChange} /> */}
      <MarkDown editorRef={editorBodyRef} />
      <h2>What did you try and what were you expecting?</h2>
      <MarkDown editorRef={editorDetailsRef} />
      <button type="submit">submit</button>
    </StyledInputForm>
  );
}

export default AskQuestion;
