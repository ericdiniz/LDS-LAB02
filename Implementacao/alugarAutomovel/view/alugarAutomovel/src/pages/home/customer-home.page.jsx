import {
  Box,
  Grid,
  Container,
  Typography,
  CircularProgress,
  TextField,
} from "@mui/material";
import NovoPedidoCardComponent from "../../components/pedido-card/novo-pedido-card.component";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import PedidoCardComponent from "../../components/pedido-card/pedido-card.component";

const user = JSON.parse(localStorage.getItem("user"));
const pedidos = 5

const CustomerHomePage = () => {
  const navigate = useNavigate();
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    setTimeout(() => {
      if (user) {
        setLoading(false);
      } else {
        navigate("/");
      }
    }, 2000);
  }, [user]);

  if (loading) {
    return (
      <Box
        sx={{
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
          minHeight: "50vh",
        }}
      >
        <CircularProgress />
      </Box>
    );
  }

  return (
    <Box sx={{ margin: 5, maxHeight: "100%" }}>
      <Grid container spacing={2}>
        <Grid item xs={3} >
          <Typography>Dados Pessoais</Typography>
          <Box>
            <TextField
              variant="standard"
              label="Nome"
              value={user.name}
              disabled
              sx={{ margin: 1 }}
            />
            <TextField
              variant="standard"
              label="CPF"
              value={user.cpf}
              disabled
              sx={{ margin: 1 }}
            />
          </Box>
        </Grid>
        <Grid item xs={9}>
          <Box>
            <NovoPedidoCardComponent />
          </Box>
          <Box sx={{marginTop:2}}>
          <Typography>Históirico de Pedidos</Typography>
          <PedidoCardComponent/>
          <PedidoCardComponent/>
          <PedidoCardComponent/>
          </Box>
        </Grid>
      </Grid>
    </Box>
  );
};

export default CustomerHomePage;
