import styled from 'styled-components';

import { ReactComponent as SearchIcon } from '../../assets/search-icon.svg';

const Container = styled.div`
  display: flex;
  align-items: center;
  width: 100%;
  max-width: 720px;
  margin-left: 8px;
  background-color: white;
  border-radius: 4px;
  border: 1px solid rgba(0, 0, 0, 0.2);
  padding: 8px;
`;

const Input = styled.input.attrs(props => ({
  placeholder: 'Search...',
}))`
  margin-left: 4px;
  border: none;
  &:focus {
    outline: none;
  }
`;

function Search() {
  return (
    <Container>
      <SearchIcon />
      <Input />
    </Container>
  );
}

export default Search;
