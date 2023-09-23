import ResponsiveAppBar from "../components/navbar/navbar.component";
import { Routes, Route } from "react-router-dom";
import LoginPage from "../pages/login/login.page";
import SingUpPage from "../pages/register/register.page";

const AllRoutes = () => {
  return (
    <div>
      <Routes>
        <Route path="/" element={<LoginPage />}></Route>
        <Route path="register" element={<SingUpPage />}></Route>
      </Routes>
    </div>
  );
};

export default AllRoutes;
