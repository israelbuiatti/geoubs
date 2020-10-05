import axios from 'axios';

const api = axios.create({
  baseURL: 'http://165.227.127.44:8090/',
});

export default api;
