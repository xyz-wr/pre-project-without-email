import { useEffect, useState } from "react";
import axios from "axios";

const useAxios = (url) => {
  const [questions, setQuestions] = useState([]);
  const [answers, setAnswers] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    axios(url, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        // ngrok 으로 데이터 받을 때 browser warning 스킵
        // 'ngrok-skip-browser-warning': '69420',
      },
    })
      .then((response) => {
        setQuestions(response.data);
        setAnswers(response.data.answers);
      })
      .catch((err) => setError(err.message));
  }, [url]);

  return [questions, setQuestions, answers, setAnswers, error];
};

export default useAxios;
