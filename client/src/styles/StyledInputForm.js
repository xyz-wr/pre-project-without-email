import styled from "styled-components";

const StyledInputForm = styled.form`
  margin-left: 30px;
  display: flex;
  flex-direction: column;
  width: 800px;
  > input {
    height: 30px;
  }
  > textarea {
    height: 200px;
  }

  > button {
    margin-top: 20px;
    width: 80px;
  }
`;

export default StyledInputForm;
