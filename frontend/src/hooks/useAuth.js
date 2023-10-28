import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { postAuth } from "../api/auth";

export const useAuth = (user, pass) => {
  const navigate = useNavigate();
  const [status, setStatus] = useState();
  useEffect(() => {
    postAuth(user, pass)
      .then((res) => {
        setStatus(res.status);
        navigate("/main");
      })
      .catch((err) => {
        setStatus(err.response.status);
        navigate("/");
      });
  }, []);
  return status;
};
