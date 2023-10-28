import axios from "axios";

const authorizationURL = "/api/auth";
export const postAuth = async (user, pass) => {
  const response = await axios.post(authorizationURL, {
    auth: { username: user, password: pass },
  });
  return response;
};
