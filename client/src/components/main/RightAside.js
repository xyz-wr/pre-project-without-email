import styled from 'styled-components';
import { ReactComponent as Square } from '../../assets/🦆 icon _comment square_.svg';
import { ReactComponent as StackOver } from '../../assets/ic-stackoverflow.svg';
import { ReactComponent as Pencil } from '../../assets/ic-pencil.svg';

const SecondInnerContainer = styled.div`
  background-color: #fdf7e2;
  margin-top: 20px;
  border-radius: 6px;
  padding: 0px;
  height: 650px;
  border: 1px solid #f7eecf;
  font-size: 13px;
  .sideborder {
    border-bottom: 1px solid #f7eecf;
  }
  .sidetitle {
    color: #606669;
    font-weight: bold;
    margin: 0px;
    padding: 18px;
    border-bottom: 1px solid #f7eecf;
    background-color: #fbf3d5;
  }
  .sidebody {
    margin: 18px;
    display: flex;
    gap: 0.5rem;
    svg {
      flex-shrink: 0;
    }
  }
`;

function RightAside() {
  return (
    <SecondInnerContainer>
      <div className="sideborder">
        <div className="sidetitle">The Overflow Blog</div>
        <div>
          <div className="sidebody">
            <Pencil />
            The philosopher who believes in Web Assembly
          </div>
          <div className="sidebody">
            <Pencil />
            Community is the future of AI
          </div>
        </div>
      </div>
      <div className="sideborder">
        <div className="sidetitle">Featured on Meta</div>
        <div className="">
          <div className="sidebody">
            <Square />
            Improving the copy in the close modal and post notices - 2023 edition
          </div>
          <div className="sidebody">
            <Square />
            New blog post from our CEO Prashanth Community is the future of AI
          </div>
          <div className="sidebody">
            <StackOver />
            Temporary policy: ChatGPT is banned
          </div>
          <div className="sidebody">
            <StackOver />
            <span>
              Content Discovery initiative 4/13 update: Related questions using a
              Machine...
            </span>
          </div>
          <div className="sidebody">
            <StackOver />
            The [protection] tag is being burninated
          </div>
        </div>
      </div>
      <div>
        <div className="sidetitle">Hot Meta Posts</div>
        <div className="sidebody">
          <StackOver />
          22 We need a better [word] for this tag
        </div>
      </div>
    </SecondInnerContainer>
  );
}

export default RightAside;
