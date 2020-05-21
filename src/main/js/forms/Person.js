import React, { useState } from "react";
import { Segment, Form, Label, Button, Message } from "semantic-ui-react";

const successMessage = (
  <Message positive>
    <Message.Header>Creation successful</Message.Header>
    <p>The entity was successfully added to the DB.</p>
  </Message>
);

const Person = ({ onSubmit }) => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [showSuccess, setShowSuccess] = useState(false);

  const submitPerson = async () => {
    if (firstName && lastName) {
      await onSubmit(firstName, lastName);
      setFirstName("");
      setLastName("");
      setShowSuccess(true);
      setTimeout(() => {
        setShowSuccess(false);
      }, 5000);
    }
  };

  const handleFirstnameChange = (e) => {
    setFirstName(e.target.value);
  };

  const handleLastNameChange = (e) => {
    setLastName(e.target.value);
  };

  return (
    <Segment color="blue">
      {showSuccess && successMessage}
      <Form onSubmit={submitPerson}>
        <p>Add a person (with first name and last name)</p>
        <Label>First name</Label>
        <Form.Input
          placeholder="Search..."
          value={firstName}
          onChange={handleFirstnameChange}
        />
        <Label>Last name</Label>
        <Form.Input
          placeholder="Last name"
          value={lastName}
          onChange={handleLastNameChange}
        />
        <Button primary type="submit">
          Submit
        </Button>
      </Form>
    </Segment>
  );
};

export default Person;
