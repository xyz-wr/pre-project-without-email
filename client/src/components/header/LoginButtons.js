import styled from 'styled-components';

const Container = styled.div`
  display: flex;
  margin-left: 6px;
  align-items: center;
  width: 132px;
  gap: 4px;
`;

const LoginButton = styled.button`
  background-color: #e1ecf4;
  color: #39739d;
  border: 1px solid #b2cbdd;
  border-radius: 4px;
  padding: 8px;
  &:hover {
    background-color: #b3d3ea;
  }
`;

const SignUpButton = styled.button`
  background-color: #1e95ff;
  color: white;
  border: 1px solid #b2cbdd;
  border-radius: 4px;
  padding: 8px;
  &:hover {
    background-color: #0074cc;
  }
`;

function LoginButtons() {
  return (
    <Container>
      <LoginButton>Log in</LoginButton>
      <SignUpButton>Sign Up</SignUpButton>
    </Container>
  );
}

export default LoginButtons;
