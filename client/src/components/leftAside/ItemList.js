import styled from 'styled-components';

const StyledItemList = styled.div`
  display: flex;
  flex-direction: column;
  p {
    padding: 10px;
    margin: 6px;
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

function ItemList({ title, children }) {
  return (
    <StyledItemList>
      <p>{title}</p>
      {children}
    </StyledItemList>
  );
}

export default ItemList;
