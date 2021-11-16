import "./Login.css";

import { Form, FormGroup, FormLabel, Button, Container } from "react-bootstrap";
import { useLogin } from "hooks/useLogin";
import { Link } from "react-router-dom";

export default function Login() {
  const { form, errors, handleOnTextChange, handleOnClickSubmit } = useLogin();

  return (
    <div className="Login">
      <Container className="card">
        <h2>Login</h2>
        <br />
        {errors.form && (
          <span className="error" style={{ color: "red" }}>
            {errors.form}
          </span>
        )}
        <Form onSubmit={handleOnClickSubmit}>
          <FormGroup>
            <FormLabel className="form-label">Username</FormLabel>
            {/* <FormLabel className="form-label">Email</FormLabel> */}
            <Form.Control
              // type="email"
              name="email"
              className="input-field"
              placeholder="Username"
              // placeholder="user@email.com"
              onChange={handleOnTextChange}
              value={form.email}
              autoFocus
              required
            />
          </FormGroup>

          {/* <FormGroup>
            <FormLabel className="form-label">Password</FormLabel>
            <Form.Control
              type="password"
              name="password"
              className="input-field"
              placeholder="password"
              onChange={handleOnTextChange}
              value={form.password}
              required
            />
          </FormGroup> */}

          <Button type="submit" className="login-btn">
            login
          </Button>
        </Form>
        <div className="footer">
          <p>
            Don't have an account? Sign up <Link to="/register">here.</Link>
          </p>
        </div>
      </Container>
    </div>
  );
}
