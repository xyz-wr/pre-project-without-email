import { BrowserRouter, Routes, Route } from 'react-router-dom';
// import styled from 'styled-components';

import Home from './pages/Home';
// import { StyledBody, AppContainer, StyledMain } from './styles/StyledApp';

// import RightSideBar from './components/RightSideBar';
// import Questions from './pages/Questions';
// import Tags from './pages/Tags';
// import Users from './pages/Users';
// import Companies from './pages/Companies';

function App() {
  return (
    <BrowserRouter>
      {/* <Home /> */}
      <Routes>
        <Route path="/" element={<Home />} />
        {/* <Route path="/questions" element={<Questions />} />
        <Route path="/tags" element={<Tags />} />
        <Route path="/users" element={<Users />} />
        <Route path="/companies" element={<Companies />} /> */}
      </Routes>
    </BrowserRouter>
  );
}

export default App;
