// import { Styledlogin, Styledloginbox } from "../styles/StyledLogIn";
import styled from 'styled-components';
import { FcGoogle } from 'react-icons/fc';
import { AiFillGithub } from 'react-icons/ai';
import { ImFacebook2 } from 'react-icons/im';

const Styledlogin = styled.div`
  border: 2px solid white;
  display: flex;
  flex-direction: column;
  width: 290px;
  margin: auto;
  > * {
    margin: 5px;
  }
`;

const GoogleButton = styled.button`
  background-color: white;
  border: 1px solid black;
  border-radius: 5px;
  height: 30px;
`;

const GithubButton = styled.button`
  background-color: #2f3337;
  color: white;
  border: white;
  border-radius: 5px;
  height: 30px;
`;

const FacebookButton = styled.button`
  background-color: #385499;
  color: white;
  border: white;
  border-radius: 5px;
  height: 30px;
`;

const Styledloginbox = styled.body`
  border: 1px solid white;
  border-radius: 5px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding-bottom: 10px;
  margin: auto;
  width: 280px;
  height: 200px;
  box-shadow: 5px 5px 5px rgb(0, 0, 0, 0.2);
  > * {
    width: 200px;
    margin-top: 3px;
    margin-bottom: 3px;
  }
  > span {
    font-weight: 500;
  }
  > input {
    height: 20px;
  }
  > input:focus {
    border: 5px solid #d9eaf7;
    border-style: outset;
  }
  > button {
    width: 210px;
    background-color: #0a95ff;
    color: white;
    border: white;
    border-radius: 2px;
    height: 30px;
    cursor: pointer;
  }
  > button:hover {
    background-color: #0074cc;
  }
`;

const LogIn = () => {
  return (
    <>
      <main>
        <Styledlogin>
          <GoogleButton>
            <FcGoogle size="19" />
            Log in with Google
          </GoogleButton>
          <GithubButton>
            <AiFillGithub size="19" />
            Log in with GitHub
          </GithubButton>
          <FacebookButton>
            <ImFacebook2 size="19" />
            Log in with Facebook
          </FacebookButton>
        </Styledlogin>

        <body>
          <Styledloginbox>
            <span>Email</span>
            <input></input>
            <span>Password</span>
            <input></input>
            <button>Log in</button>
          </Styledloginbox>
        </body>
      </main>
    </>
  );
};

export default LogIn;
