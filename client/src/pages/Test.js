// import styled from 'styled-components';
// import useAxios from '../services/useAxios';
// import { axiosCreate, axiosDelete } from '../services/api';
// // import Input from '../component/Input';
// import useInput from '../services/useInput';

// const StyledForm = styled.form`
//   display: flex;
//   flex-direction: column;
//   width: 400px;

//   > input {
//     margin: 10px 0 30px 0;
//     width: 200px;
//   }

//   > button {
//     width: 50px;
//   }
// `;

// function Test() {
//   const [users] = useAxios(`http://localhost:3001/users`);
//   const nameBind = useInput('');
//   const emailBind = useInput('');

//   const handleSubmit = e => {
//     e.preventDefault();
//     const data = {
//       name: nameBind.curValue,
//       email: emailBind.curValue,
//     };
//     axiosCreate('http://localhost:3001/users/', data);
//   };

//   const handleDelete = id => {
//     axiosDelete(`http://localhost:3001/users/`, id);
//   };

//   return (
//     <div>
//       <ul>
//         {users.map(user => (
//           <li key={user.id}>
//             {user.name} ({user.email})
//             <button onClick={() => handleDelete(user.id)}>삭제</button>
//           </li>
//         ))}
//       </ul>
//       <StyledForm onSubmit={handleSubmit}>
//         <Input label="name" value={nameBind} />
//         <Input label="email" value={emailBind} />
//         <button>등록</button>
//       </StyledForm>
//     </div>
//   );
// }

// export default Test;
