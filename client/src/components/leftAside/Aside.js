import styled from 'styled-components';
import { ReactComponent as Earth } from '../../assets/ic-earth.svg';
import { ReactComponent as Star } from '../../assets/start.svg';
import { ReactComponent as Team } from '../../assets/team_img.svg';

const Container = styled.div`
  width: 164px;
  /* height: 170vh; */
  background-color: white;
  /* padding: 0px; */
  border-right: 1px solid lightgray;
`;

const InnerContainer = styled.div`
  /* display: flex;
  flex-direction: column; */
  position: sticky;
  top: 64px;
  font-size: 13px;
  color: #525960;
`;

const ItemList = styled.div`
  display: flex;
  flex-direction: column;
  p {
    padding: 10px;
    margin: 6px;
  }
  button {
    cursor: pointer;
    display: flex;
    align-items: center;
    gap: 0.4rem;
    border: none;
    padding: 10px;
    background-color: white;
    text-align: left;
    &:active {
      padding: 10px;
      background-color: #f1f2f3;
      font-weight: bold;
      /* margin: 0px; */
      border-right: 3px solid #f48024;
      .earth_icon {
        path {
          fill: black;
        }
      }
    }
  }
  .star_icon {
    padding: 0px 2px;
    path {
      fill: #f48024;
    }
  }
  .pl {
    padding-left: 35px;
  }
`;

const SideInnerBox = styled.div`
  border: 1px solid lightgray;
  padding: 10px;
  button {
    background-color: #f38225;
    color: white;
    border-radius: 5px;
  }
`;

const WhyText = styled.div`
  padding: 6.6px;
  text-align: center;
`;

function Aside() {
  return (
    <Container>
      <InnerContainer>
        <ItemList>
          <p>Home</p>
        </ItemList>
        <ItemList>
          <p>PUBLIC</p>
          <button>
            <Earth className="earth_icon" /> Questions
          </button>
          <button className="pl">Tags</button>
          <button className="pl">Users</button>
          <button className="pl">Companies</button>
        </ItemList>
        <ItemList>
          <p>COLLECTIVES</p>
          <div>
            <Star className="star_icon" /> Explore Collectives
          </div>
        </ItemList>
        <ItemList>
          <p>TEAMS</p>
          <SideInnerBox>
            <div>
              <b>Stack Overflow for Teams</b> - Start collaborating and sharing
              organizational knowledge
            </div>
            <Team />
            <div>
              <button>Create a free Team</button>
              <WhyText>why Teams?</WhyText>
            </div>
          </SideInnerBox>
        </ItemList>
      </InnerContainer>
    </Container>
  );
}

export default Aside;
