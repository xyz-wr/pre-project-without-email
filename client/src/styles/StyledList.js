import styled from "styled-components";

const StyledList = styled.div`
  display: flex;
  flex-direction: column;
  width: 800px;
  margin-left: 30px;
  > button {
    background-color: transparent;
    border: none;
    color: blue;
    margin-top: 30px;
    width: 50px;
    cursor: pointer;
    pointer-events: auto;

    :hover {
      color: skyblue;
    }
  }
`;
export default StyledList;
