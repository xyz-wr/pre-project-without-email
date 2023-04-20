import { useCallback, useState } from "react";

const useInput = () => {
  const [curValue, setCurValue] = useState("");

  const bind = {
    curValue,
    onChange: useCallback((e) => {
      const { value } = e.target;
      setCurValue(value);
    }, []),
  };

  return bind;
};

export default useInput;
