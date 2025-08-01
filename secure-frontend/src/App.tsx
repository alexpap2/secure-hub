import './App.css'
import 'bootstrap/dist/css/bootstrap.min.css';
import axios from 'axios';

function App() {

  axios.post('http://localhost:8080/babis/test/login', {
    username: 'bab',
    password: 'password'
  })
  .then(function (response) {
    console.log(response);
  })
  .catch(function (error) {
    console.log(error);
  });

  return (
    <>
      <button className='btn btn-primary col-1'>Click me</button>
    </>
  )
}

export default App
