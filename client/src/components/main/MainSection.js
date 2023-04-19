import styled from 'styled-components';
import Questions from './Questions';

const InnerContainer = styled.div`
  /* position: fixed; */
  /* display: flex; */
  padding: 20px;
`;

const TopFirst = styled.div`
  display: flex;
  justify-content: space-between;
  /* padding: 0px 20px;
  margin: 0px; */
  width: 802px;
`;

const QHeader = styled.h1`
  font-size: 1.8rem;
  font-weight: normal;
  margin: 0px;
`;

const BlueButton = styled.button`
  background-color: #1e95ff;
  color: white;
  border: 0;
  border-radius: 5px;
  padding: 12px 10px;
`;

const TopSecond = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 802px;
  margin-top: 10px;
  p {
    font-size: 18px;
  }
`;

const ButtonList = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  /* margin-top: 30px; */
  button {
    height: 35.03px;
    padding: 9.3px;
    margin: 0px -1px -1px 0px;
    color: #6a737c;
    font-size: 14px;
    background-color: #fff;
    border: 1px solid #6a737c;
    border-radius: 2px;
    cursor: pointer;
    :active {
      background-color: #e3e6e8;
    }
  }
  .filter {
    margin: 13px;
  }
`;

function MainSection() {
  return (
    <InnerContainer>
      <TopFirst>
        <QHeader>All Questions</QHeader>
        <BlueButton>Ask Question</BlueButton>
      </TopFirst>
      <TopSecond>
        <p>23,645,216 questions</p>
        <ButtonList>
          <button>Newest</button>
          <button>Active</button>
          <button>Bountied</button>
          <button>Unanswered</button>
          <button>More</button>

          <button className="filter">Filter</button>
        </ButtonList>
      </TopSecond>

      <Questions />
      <Questions />
      <Questions />
      <Questions />
      <Questions />
      <Questions />
      <Questions />
      <Questions />
      <Questions />
      <Questions />
    </InnerContainer>
  );
}

export default MainSection;
