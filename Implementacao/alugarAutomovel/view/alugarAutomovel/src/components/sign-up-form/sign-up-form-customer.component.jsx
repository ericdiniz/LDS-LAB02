import { useEffect, useState } from "react";
import Avatar from "@mui/material/Avatar";
import Button from "@mui/material/Button";
import CssBaseline from "@mui/material/CssBaseline";
import TextField from "@mui/material/TextField";

import Grid from "@mui/material/Grid";
import Box from "@mui/material/Box";
import LockOutlinedIcon from "@mui/icons-material/LockOutlined";
import Typography from "@mui/material/Typography";
import Container from "@mui/material/Container";
import { Link } from "react-router-dom";
import axios from "axios";

const initialForm = {
  name: "",
  cpf: "",
  rg: "",
  address: "",
  profession: "",
  income0: "",
  income1: "",
  income2: "",
  password: "",
  confirmPassword: "",
};

const validatePassword = (password, confirmPassword) => {
  return password === confirmPassword;
};

const SignUpCustomer = () => {
  const [form, setForm] = useState(initialForm);

  useEffect(() => {
    console.log(form);
  }, [form]);

  const handleSubmit = async (event) => {
    event.preventDefault();
    const passwordEqual = validatePassword(form.password, form.confirmPassword);
    if (!passwordEqual) {
      return alert("As senhas não são iguais");
    }

    const finalform = {
      name: form.name,
      login: form.cpf,
      cpf: form.cpf,
      rg: form.rg,
      address: form.address,
      profession: form.profession,
      income: [form.income0, form.income1, form.income2],
      password: form.password,
    };

    console.log(finalform);
    try {
      await axios.post("http://localhost:8099/customer", finalform);
      console.log("Conta registrada com sucesso");
    } catch (error) {
      alert("Ocorreu um erro", error);
      console.log(error);
    }
  };

  const handleChangeForm = (event) => {
    const { name, value } = event.target;
    setForm({ ...form, [name]: value });
  };

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
                onChange={handleChangeForm}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id="cpf"
                label="CPF"
                name="cpf"
                onChange={handleChangeForm}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id="rg"
                label="RG"
                name="rg"
                onChange={handleChangeForm}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id="address"
                label="Endereço"
                name="address"
                onChange={handleChangeForm}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id="profession"
                label="Profissão"
                name="profession"
                onChange={handleChangeForm}
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
                onChange={handleChangeForm}
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
                onChange={handleChangeForm}
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
                name="income0"
                label="valor"
                type="text"
                id="income0"
                onChange={handleChangeForm}
              />
            </Grid>
            <Grid item xs={4}>
              <TextField
                required
                fullWidth
                name="income1"
                label="valor"
                type="text"
                id="income1"
                onChange={handleChangeForm}
              />
            </Grid>
            <Grid item xs={4}>
              <TextField
                required
                fullWidth
                name="income2"
                label="valor"
                type="text"
                id="income2"
                onChange={handleChangeForm}
              />
            </Grid>
          </Grid>
          <Button
            type="submit"
            fullWidth
            variant="contained"
            sx={{ mt: 3, mb: 2 }}
            onClick={handleSubmit}
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
