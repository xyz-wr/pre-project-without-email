import { Link } from "react-router-dom";
import useAxios from "../services/useAxios";

import StyledQuestions from "../styles/StyledQuestions";

function Questions() {
  // ERR_NGROK_3200
  // Tunnel 3350-112-148-55-154.ngrok-free.app not found

  // 이거 몰랐던거 개발 서버 껐다가 켜니까 됨
  const devUrl = process.env.REACT_APP_DEV_URL;

  const [questions] = useAxios(
    `${devUrl}/questions`,
    // api1 없이 questions로 접근했을 경우
    // react route로 설정한 주소랑 요청하는 주소랑 겹쳐서
  );
  // console.log('받은 questions: ', questions);
  // 백엔드에서 questionId 라는 키값을 이미 만들어뒀기 때문에 .id 가 아니고 .questionId

  return (
    <div>
      <StyledQuestions>
        {questions.map((question) => (
          <li key={question.id}>
            <Link to={`/questions/${question.id}`}>
              <h2>{question.title}</h2>
            </Link>
          </li>
        ))}
        <Link to="/questions/ask">
          <button type="button">ask question</button>
        </Link>
      </StyledQuestions>
    </div>
  );
}

export default Questions;
