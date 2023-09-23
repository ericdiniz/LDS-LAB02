import * as React from "react";
import Avatar from "@mui/material/Avatar";
import Button from "@mui/material/Button";
import CssBaseline from "@mui/material/CssBaseline";
import TextField from "@mui/material/TextField";
import FormControlLabel from "@mui/material/FormControlLabel";
import Checkbox from "@mui/material/Checkbox";
import Grid from "@mui/material/Grid";
import Box from "@mui/material/Box";
import LockOutlinedIcon from "@mui/icons-material/LockOutlined";
import Typography from "@mui/material/Typography";
import Container from "@mui/material/Container";
import { Link } from "react-router-dom";

const SignUpCustomer = () => {
  const handleSubmit = (event) => {};

  return (
    <Container component="main" maxWidth="xs">
      <CssBaseline />
      <Box
        sx={{
          marginTop: 8,
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
        }}
      >
        <Avatar sx={{ m: 1, bgcolor: "secondary.main" }}>
          <LockOutlinedIcon />
        </Avatar>
        <Typography component="h1" variant="h5">
          Criar uma conta com CPF
        </Typography>
        <Box component="form" noValidate onSubmit={handleSubmit} sx={{ mt: 3 }}>
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <TextField
                name="name"
                required
                fullWidth
                id="name"
                label="Nome"
                autoFocus
              />
            </Grid>
            <Grid item xs={12}>
              <TextField required fullWidth id="cpf" label="CPF" name="cpf" />
            </Grid>
            <Grid item xs={12}>
              <TextField required fullWidth id="rg" label="RG" name="rg" />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id="adress"
                label="Endereço"
                name="adress"
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id="profession"
                label="Profissão"
                name="adress"
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                name="password"
                label="Senha"
                type="password"
                id="password"
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                name="confirmPassword"
                label="Confirmar Senha"
                type="password"
                id="confirmPassword"
              />
            </Grid>

            <Grid item xs={12}>
              <Typography component="p">
                Informe seu rendimento dos três últimos meses
              </Typography>
            </Grid>

            <Grid item xs={4}>
              <TextField
                required
                fullWidth
                name="income-0"
                label="valor"
                type="text"
                id="income-0"
              />
            </Grid>
            <Grid item xs={4}>
              <TextField
                required
                fullWidth
                name="income-1"
                label="valor"
                type="text"
                id="income-1"
              />
            </Grid>
            <Grid item xs={4}>
              <TextField
                required
                fullWidth
                name="income-2"
                label="valor"
                type="text"
                id="income-2"
              />
            </Grid>
          </Grid>
          <Button
            type="submit"
            fullWidth
            variant="contained"
            sx={{ mt: 3, mb: 2 }}
          >
            Registrar
          </Button>
          <Grid container justifyContent="flex-end">
            <Grid item>
              <Link to={"/"}>Já tem uma conta? faça login</Link>
            </Grid>
          </Grid>
        </Box>
      </Box>
    </Container>
  );
};

export default SignUpCustomer;
