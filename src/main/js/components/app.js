import React, { useState } from "react";
import {
  Container,
  Segment,
  Form,
  Dimmer,
  Loader,
  Table,
  Button,
  Header,
} from "semantic-ui-react";
import { get, post, deleteAction } from "../apiService";
import QuestionForm from "../forms/QuestionForm";

const App = () => {
  const [loading, setLoading] = useState(false);
  const [query, setQuery] = useState("");
  const [results, setResults] = useState([]);

  const submitForm = async () => {
    console.log(query);
    let baseUrl = "/api/customers/";
    setLoading(true);
    let params;
    if (query) {
      params = {
        firstName: query,
      };
    }
    const jsonBody = await get(baseUrl, params);
    console.log(jsonBody);
    setLoading(false);
    setResults(jsonBody);
  };

  const addPerson = async (firstName, lastName, answerA, answerB, answerC, answerD, answerE) => {
    setLoading(true);
    const respose = await post("/api/customers/", {
      firstName,
      lastName,
      answerA, answerB, answerC, answerD, answerE,
    });
    console.log(respose);
    setLoading(false);
  };

  const handleInputChange = (e) => {
    setQuery(e.target.value);
  };

  const deleteById = async (id) => {
    console.log("deleting ", id);
    setLoading(true);
    await deleteAction("/api/customers/", id);
    setResults([]);
    setLoading(false);
  };

  const mapResultsToTable = () => {
    return (
      <>
        <hr />
        <Table celled>
          <Table.Header>
            <Table.Row>
              <Table.HeaderCell>Question</Table.HeaderCell>
              <Table.HeaderCell>Answer A</Table.HeaderCell>
              <Table.HeaderCell>Answer B</Table.HeaderCell>
              <Table.HeaderCell>Answer C</Table.HeaderCell>
              <Table.HeaderCell>Answer D</Table.HeaderCell>
              <Table.HeaderCell>Answer E</Table.HeaderCell>
            </Table.Row>
            {results.map((r) => (
              <Table.Row key={r.id}>
                <Table.Cell>{r.firstName}</Table.Cell>
                <Table.Cell>{r.answerA}</Table.Cell>
                <Table.Cell>{r.answerB}</Table.Cell>
                <Table.Cell>{r.answerC}</Table.Cell>
                <Table.Cell>{r.answerD}</Table.Cell>
                <Table.Cell>{r.answerE}</Table.Cell>
                <Table.Cell>
                  <Button color="red" onClick={() => deleteById(r.id)}>
                    Delete
                  </Button>
                </Table.Cell>
              </Table.Row>
            ))}
          </Table.Header>
        </Table>
      </>
    );
  };

  return (
    <Container>
      <Header as="h3">Main application</Header>
      <QuestionForm onSubmit={addPerson} />
      <hr />
      <Segment color="blue">
        <Form onSubmit={submitForm}>
          <p>Search for people by first name</p>
          <Form.Input
            placeholder="Search..."
            value={query}
            onChange={handleInputChange}
          />
        </Form>
      </Segment>
      {loading && (
        <Dimmer active inverted>
          <Loader inverted>Loading...</Loader>
        </Dimmer>
      )}
      {results && results.length > 0 && mapResultsToTable()}
    </Container>
  );
};

export default App;
