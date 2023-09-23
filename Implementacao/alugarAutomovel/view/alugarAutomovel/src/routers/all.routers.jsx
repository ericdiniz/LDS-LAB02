import ResponsiveAppBar from "../components/navbar/navbar.component";
import { Routes, Route } from "react-router-dom";
import LoginPage from "../pages/login/login.page";
import SingUpPage from "../pages/register/register.page";
import NotFound from "../pages/notfound/notefound.page";
import CustomerHomePage from "../pages/home/customer-home.page";

const AllRoutes = () => {
  return (
    <div>
      <Routes>
        <Route path="/" element={<LoginPage />} />
        <Route path="register" element={<SingUpPage />} />
        <Route path="*" element={<NotFound />} />
        <Route path="customer-home" element={<ResponsiveAppBar/>}>
          <Route index element={<CustomerHomePage/>} />
        </Route>
      </Routes>
    </div>
  );
};

export default AllRoutes;
