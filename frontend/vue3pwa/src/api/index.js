import axios from "axios";

function create(BASE_URL) {
  const instance = axios.create({
      baseURL: BASE_URL,
      // headers: {
      //     'Content-Type': 'application/json',
      // },
      withCredentials: true,
    });
  return instance;
}

export const markers = create(`${process.env.VUE_APP_API_URL}api/map/markers`);

export const comments = create(`${process.env.VUE_APP_API_URL}api/map/comments`);
