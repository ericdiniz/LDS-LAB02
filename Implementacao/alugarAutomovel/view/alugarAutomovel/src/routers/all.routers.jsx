import ResponsiveAppBar from "../components/navbar/navbar.component";
import { Routes, Route } from "react-router-dom";
import LoginForm from "../pages/login/loginForm.component";


const AllRoutes = () => {
  return (
    <div>
      <Routes>
        <Route path="/" element={<LoginForm />}></Route>
      </Routes>
    </div>
  );
};

export default AllRoutes;
