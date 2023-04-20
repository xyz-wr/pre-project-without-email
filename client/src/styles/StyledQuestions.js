import styled from 'styled-components';

const StyledQuestions = styled.ul`
  display: flex;
  flex-direction: column;
  width: 400px;
  > li {
    list-style: none;
  }

  a {
    text-decoration: none;
    color: black;
    :hover {
      color: gray;
    }
  }
`;

export default StyledQuestions;
