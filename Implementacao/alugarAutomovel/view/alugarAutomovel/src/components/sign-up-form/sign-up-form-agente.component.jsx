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
  cnpj: "",
  password: "",
  confirmPassword: "",
};

const validatePassword = (password, confirmPassword) => {
  return password === confirmPassword;
};

const SignUpAgent = () => {
  const [form, setForm] = useState(initialForm);
  const handleSubmit = async (event) => {
    event.preventDefault();
    const passwordEqual = validatePassword(form.password, form.confirmPassword);
    if (!passwordEqual) {
      return alert("As senhas não são iguais");
    }

    const finalForm = {
      login: form.cnpj,
      cnpj: form.cnpj,
      password: form.password,
    };

    try {
      await axios.post("http://localhost:8099/agents", finalForm);
      console.log("Conta registrada com sucesso");
    } catch (error) {
      alert("Ocorreu um erro", error);
      console.log(error);
    }
  };

  const handlChageForm = (event) => {
    const { value, name } = event.target;
    setForm({ ...form, [name]: value });
  };

  useEffect(() => {
    console.log(form);
  }, [form]);

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
          Criar uma conta com CNPJ
        </Typography>
        <Box component="form" noValidate onSubmit={handleSubmit} sx={{ mt: 3 }}>
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id="cnpj"
                label="CNPJ"
                name="cnpj"
                onChange={handlChageForm}
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
                onChange={handlChageForm}
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
                onChange={handlChageForm}
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

export default SignUpAgent;
