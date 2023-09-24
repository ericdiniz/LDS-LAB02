import * as React from "react";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Container from "@mui/material/Container";
import Button from "@mui/material/Button";
import DirectionsCarFilledIcon from "@mui/icons-material/DirectionsCarFilled";
import { Stack } from "@mui/material";
import { Link, useNavigate } from "react-router-dom";
import { Outlet } from "react-router-dom";


const initialPage = JSON.parse(localStorage.getItem("homePage")) || "/";

function ResponsiveAppBar() {
  const navigate = useNavigate();
  const handleLogOut = () => {
    localStorage.clear();
    navigate("/");
  };
  return (
    <Box
      sx={{
        height: "100vh",
        background: "linear-gradient(to bottom, #e8eaed, #ffffff)",
      }}
    >
      <AppBar position="static">
        <Container maxWidth="xl">
          <Toolbar
            disableGutters
            sx={{
              display: "flex",
              alignItems: "center",
              justifyContent: "space-between",
            }}
          >
            <Box sx={{ display: "flex", marginRight: 0 }}>
              <DirectionsCarFilledIcon sx={{ marginRight: 2 }} />
              <Typography
                variant="h6"
                noWrap
                component="a"
                href={initialPage.route}
                sx={{
                  mr: 2,
                  display: { xs: "none", md: "flex" },
                  fontFamily: "monospace",
                  fontWeight: 700,
                  letterSpacing: ".3rem",
                  color: "inherit",
                  textDecoration: "none",
                }}
              >
                ALUGAR AUTOMÓVEL
              </Typography>
            </Box>

            <Stack spacing={2} direction="row">
              <Button variant="outlined" color="warning" onClick={handleLogOut}>
                Log out
              </Button>
            </Stack>
          </Toolbar>
        </Container>
      </AppBar>
      <Outlet />
    </Box>
  );
}
export default ResponsiveAppBar;
