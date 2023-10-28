import { useLocation } from "react-router-dom";
import { useAuth } from "../hooks/useAuth";

export const PrivateRouteMain = () => {
  const { state } = useLocation();
  useAuth(state["user"], state["pass"]);
};
