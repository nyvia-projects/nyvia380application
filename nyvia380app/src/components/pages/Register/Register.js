import "./Register.css";

import {
  Form,
  FormGroup,
  FormLabel,
  FormControl,
  Button,
  Container,
} from "react-bootstrap";
import { useRegister } from "hooks/useRegister";
import { Link } from "react-router-dom";

export default function Register() {
  const { form, errors, passwordStrength, handleOnTextChange, handleOnClickSubmit } =
    useRegister();

  return (
    <div className="Register">
      <Container className="card">
        <h2>Sign Up</h2>
        <br />
        <Form onSubmit={handleOnClickSubmit}>
          <FormGroup>
            <FormLabel className="form-label">Username</FormLabel>
            <Form.Control
              name="alias"
              className="input-field"
              placeholder="Enter a valid username"
              onChange={handleOnTextChange}
              value={form.alias}
              autoFocus
              required
            />
          </FormGroup>

          
          {/* <FormGroup>
            <FormLabel className="form-label">Email</FormLabel>
            <Form.Control
              type="email"
              name="email"
              className="input-field"
              placeholder="Enter a valid email"
              onChange={handleOnTextChange}
              value={form.email}
              isValid={!errors.email && errors.email !== undefined}
              isInvalid={errors.email}
              autoFocus
              required
            />
          </FormGroup>
          <FormControl.Feedback type="isInvalid" style={{ color: "red" }}>
            {errors.email}
          </FormControl.Feedback> */}

          <div className="split-input-field">
            <FormGroup>
              <FormLabel className="form-label">First Name</FormLabel>
              <Form.Control
                type="text"
                name="firstName"
                className="input-field"
                placeholder="First"
                onChange={handleOnTextChange}
                value={form.firstName}
                isValid={!errors.firstName && errors.firstName !== undefined}
                isInvalid={errors.firstName}
                required
              />
            </FormGroup>

            <FormGroup>
              <FormLabel className="form-label">Last Name</FormLabel>
              <Form.Control
                type="text"
                name="lastName"
                className="input-field"
                placeholder="Last"
                onChange={handleOnTextChange}
                value={form.lastName}
                isValid={!errors.lastName && errors.lastName !== undefined}
                isInvalid={errors.lastName}
                required
              />
            </FormGroup>

            <FormGroup>
              <FormLabel className="form-label">Age</FormLabel>
              <Form.Control
                type="number"
                name="age"
                className="input-field"
                onChange={handleOnTextChange}
                value={form.age}
                required
              />
            </FormGroup>
            
          </div>

          {/* <FormGroup>
            <FormLabel className="form-label">Password</FormLabel>
            <Form.Control
              type="password"
              name="password"
              className="input-field"
              placeholder="Enter a secure password"
              onChange={handleOnTextChange}
              value={form.password}
              required
            />
          </FormGroup>
          <div className={`passwordStrength ${passwordStrength}`}>
            {form.password && (
              <span>
                {passwordStrength}
              </span>
            )}
          </div> */}

          {/* <FormGroup>
            <FormLabel className="form-label">Confirm Password</FormLabel>
            <Form.Control
              type="password"
              name="confirmPassword"
              className="input-field"
              placeholder="Confirm your password"
              onChange={handleOnTextChange}
              value={form.confirmPassword}
              isValid={
                !errors.confirmPassword && errors.confirmPassword !== undefined
              }
              isInvalid={errors.confirmPassword}
              required
            />
          </FormGroup>
          <FormControl.Feedback
            type="isInvalid"
            style={{ color: "red" }}
          >
            {errors.confirmPassword}
          </FormControl.Feedback>

          <FormGroup>
            <Form.Check
              id="agreeBox"
              defaultValue="#563d7c"
              type="checkbox"
              label="Agree To Terms and Services"
              required
            />
          </FormGroup> */}
          

          <Button type="submit" className="register-btn">
            Register
          </Button>
        </Form>
        <div className="footer">
          <p>
            Already have an account? Login <Link to="/login">here.</Link>
          </p>
        </div>
      </Container>
    </div>
  );
}
