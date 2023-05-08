import axios from "axios";

function create(baseURL, options) {
  const instance = axios.create(Object.assign({ baseURL }, options));
  return instance;
}

export const markers = create(`${process.env.VUE_APP_API_URL}map/markers`);

export const comments = create(`${process.env.VUE_APP_API_URL}map/comments`);
