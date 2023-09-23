import SignUpCustomer from "../../components/sign-up-form/sign-up-form-customer.component";
import SignUpAgent from "../../components/sign-up-form/sign-up-form-agente.component";
import { useState } from "react";
import {
  Box,
  Grid,
  Radio,
  RadioGroup,
  FormControl,
  FormControlLabel,
} from "@mui/material";

const SingUpPage = () => {
  const [selectedOption, setSelectedOption] = useState("cpf");

  const handleOptionChange = (event) => {
    setSelectedOption(event.target.value);
  };
  return (
    <Box>
      <Grid container spacing={2}>
        <Grid item xs={6}>
          <Box sx={{ textAlign: "center" }}>
            <FormControl component="fieldset">
              <RadioGroup
                row
                aria-label="tipo"
                name="tipo"
                value={selectedOption}
                onChange={handleOptionChange}
              >
                <FormControlLabel
                  value="cpf"
                  control={<Radio />}
                  label={<span style={{ textAlign: "center" }}>CPF</span>}
                />
                <FormControlLabel
                  value="cnpj"
                  control={<Radio />}
                  label={<span style={{ textAlign: "center" }}>CNPJ</span>}
                />
              </RadioGroup>
            </FormControl>
          </Box>
          {selectedOption == "cpf" ? <SignUpCustomer /> : <SignUpAgent/>}
        </Grid>
        <Grid item xs={6}>
          <Box
            sx={{
              display: "flex",
              flexDirection: "column",
              alignItems: "center",
              backgroundImage:
                'url("https://images.pexels.com/photos/1402787/pexels-photo-1402787.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")', // Replace with your image URL
              backgroundSize: "cover",
              backgroundPosition: "center",
              backgroundRepeat: "no-repeat",
              opacity: "95%",
              minHeight: "100vh", // Ensure the background covers the entire viewport height
            }}
          />
        </Grid>
      </Grid>
    </Box>
  );
};

export default SingUpPage;
