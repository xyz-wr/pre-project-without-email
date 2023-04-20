import styled from 'styled-components';

const Container = styled.div`
  display: flex;
  /* justify-content: ; */
  border-top: 1px solid lightgray;
  padding-top: 10px;
  height: 110px;
`;

const QAnswer = styled.div`
  width: 100px;
  font-size: 13px;
  display: flex;
  flex-direction: column;
  align-items: end;
  margin-top: 2px;
  margin-right: 13px;
  gap: 8px;
  .answer {
    color: #6b737c;
  }
`;

const QDetail = styled.div`
  width: 595px;
  height: 128px;
  .qtitle {
    color: #1675cc;
    /* font-weight: bold; */
    font-size: 18px;
  }
  .qbody {
    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;
    font-size: 13px;
    color: #6c7074;
    margin-top: 5px;
  }
`;

const QUser = styled.div`
  font-size: 13px;
  display: flex;
  justify-content: end;
  gap: 4px;
  margin-top: 5px;
  .username {
    color: #1574cc;
  }
  .reputation {
    font-weight: bold;
  }
  .time {
    color: #8c9199;
  }
  img {
    width: 16px;
    height: 16px;
  }
`;

function Questions() {
  return (
    <Container>
      <QAnswer>
        <p>0 votes</p>
        <p className="answer">0 answers</p>
        <p className="answer">0 views</p>
      </QAnswer>
      <QDetail>
        <h3 className="qtitle">Stop spacy from deleting stopwords in split strings</h3>
        <p className="qbody">
          Im trying to use spacy to remove stopwords from a panda dataframe created from a
          csv. My issue is that Im trying to account for words that might have a mix of
          words and numbers.If a number separates a word so that it contains a stop word,
          it will delete that portion of the word.
        </p>
        <QUser>
          <img
            src="https://www.gravatar.com/avatar/9809af9b625621928e70e9f40ef050a4?s=32&d=identicon&r=PG&f=1"
            alt="useravatar"
          />
          <span className="username">Jared</span>
          <span className="reputation">11</span>
          <span className="time">asked 44 mins ago</span>
        </QUser>
      </QDetail>
    </Container>
  );
}

export default Questions;
