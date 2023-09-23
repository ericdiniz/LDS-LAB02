import * as React from "react";
import { styled } from "@mui/material/styles";
import Card from "@mui/material/Card";
import CardHeader from "@mui/material/CardHeader";
import AddIcon from "@mui/icons-material/Add";
import CardContent from "@mui/material/CardContent";
import CardActions from "@mui/material/CardActions";
import Collapse from "@mui/material/Collapse";
import IconButton from "@mui/material/IconButton";
import ExpandMoreIcon from "@mui/icons-material/ExpandMore";
import { TextField } from "@mui/material";

const ExpandMore = styled((props) => {
  const { expand, ...other } = props;
  return <IconButton {...other} />;
})(({ theme, expand }) => ({
  transform: !expand ? "rotate(0deg)" : "rotate(180deg)",
  marginLeft: "auto",
  transition: theme.transitions.create("transform", {
    duration: theme.transitions.duration.shortest,
  }),
}));

const PedidoCardComponent = ({ pedido }) => {
  const [expanded, setExpanded] = React.useState(false);

  const handleExpandClick = () => {
    setExpanded(!expanded);
  };

  const dadosPedido = {
    id: 22,
    cliente: 1,
    automovel: "ford Ka",
    data: "2023-09-20",
    status: "Em Analise",
    contrato: "Prorpiedade do Cliente",
  };

  return (
    <Card sx={{ maxWidth: "100%" }}>
      <CardHeader
        avatar={
          <AddIcon
            fontSize="large"
            sx={{ color: "blue" }}
            onClick={handleExpandClick}
          />
        }
        title={dadosPedido.id}
        onClick={handleExpandClick}
      />

      <CardActions disableSpacing>
        <ExpandMore
          expand={expanded}
          onClick={handleExpandClick}
          aria-expanded={expanded}
          aria-label="show more"
        >
          <ExpandMoreIcon />
        </ExpandMore>
      </CardActions>
      <Collapse in={expanded} timeout="auto" unmountOnExit>
        <CardContent>
          <TextField name="Carro" value={dadosPedido.automovel} />
        </CardContent>
      </Collapse>
    </Card>
  );
};

export default PedidoCardComponent;
