import { BrowserRouter, Route, Routes } from "react-router-dom";
import { PrivateRouteMain } from "./component/PrivateRouteMain";
import { Login } from "./pages/Login";
import { Main } from "./pages/Main";
import { Page1 } from "./pages/Page1";
import { Page2 } from "./pages/Page2";

export const Routers = () => {
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/auth" element={<PrivateRouteMain />} />
          <Route path="/main" element={<Main />}>
            <Route path="/main/page1" element={<Page1 />} />
            <Route path="/main/page2" element={<Page2 />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
};
