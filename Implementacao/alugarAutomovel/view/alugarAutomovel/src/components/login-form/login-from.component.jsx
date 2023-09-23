import { useEffect, useState } from "react";
import Avatar from "@mui/material/Avatar";
import Button from "@mui/material/Button";
import CssBaseline from "@mui/material/CssBaseline";
import TextField from "@mui/material/TextField";
import Paper from "@mui/material/Paper";
import Box from "@mui/material/Box";
import Grid from "@mui/material/Grid";
import { Link } from "react-router-dom";

import CarRentalIcon from "@mui/icons-material/CarRental";
import Typography from "@mui/material/Typography";

const initialForm = {
  login: "",
  password: "",
};

const handleSubmit = (event) => {};

const LoginForm = () => {
  const [form, setForm] = useState(initialForm);

  const handleChangeForm = (event) => {
    const { name, value } = event.target;
    setForm({ ...form, [name]: value });
  };

  // useEffect(() => {
  //   console.log(form);
  // }, [form]);

  return (
    <Box>
      <Grid container component="main" sx={{ height: "100vh" }}>
        <CssBaseline />
        <Grid
          item
          xs={false}
          sm={4}
          md={7}
          sx={{
            backgroundImage:
              "url(https://images.pexels.com/photos/1519192/pexels-photo-1519192.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1)",
            backgroundRepeat: "no-repeat",
            backgroundColor: (t) =>
              t.palette.mode === "light"
                ? t.palette.grey[50]
                : t.palette.grey[900],
            backgroundSize: "cover",
            backgroundPosition: "center",
          }}
        />
        <Grid item xs={12} sm={8} md={5} component={Paper} elevation={6} square>
          <Box
            sx={{
              my: 8,
              mx: 4,
              display: "flex",
              flexDirection: "column",
              alignItems: "center",
            }}
          >
            <Avatar sx={{ m: 1, bgcolor: "secondary.dark" }}>
              <CarRentalIcon />
            </Avatar>
            <Typography component="h1" variant="h5">
              ALUGAR AUTOMÓVEL
            </Typography>
            <Box
              component="form"
              noValidate
              onSubmit={handleSubmit}
              sx={{ mt: 1 }}
            >
              <TextField
                margin="normal"
                required
                fullWidth
                id="login"
                label="CNPJ/CPF"
                name="login"
                autoComplete="login"
                helperText="Only numbers"
                autoFocus
                onChange={handleChangeForm}
              />
              <TextField
                margin="normal"
                required
                fullWidth
                name="password"
                label="Password"
                type="password"
                id="password"
                autoComplete="current-password"
                onChange={handleChangeForm}
              />

              <Button
                type="submit"
                fullWidth
                variant="contained"
                sx={{ mt: 3, mb: 2 }}
              >
                ENTRAR
              </Button>
              <Grid container>
                <Grid item xs>
                  <Link to={"recover"}>Redefinir senha</Link>
                </Grid>
                <Grid item>
                  <Link to={"register"}>Não tem uma conta? Registrar!</Link>
                </Grid>
              </Grid>
            </Box>
          </Box>
        </Grid>
      </Grid>
    </Box>
  );
};

export default LoginForm;
