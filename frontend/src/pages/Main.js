import { Outlet } from "react-router-dom";
import { Header } from "../component/Header";

export const Main = () => {
  return (
    <div>
      <Header />
      <Outlet />
    </div>
  );
};
