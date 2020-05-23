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
    let baseUrl = "/api/questions/";
    setLoading(true);
    let params;
    if (query) {
      params = {
        question: query,
      };
    }
    const jsonBody = await get(baseUrl, params);
    console.log(jsonBody);
    setLoading(false);
    setResults(jsonBody);
  };

  const addQuestion = async (question, noAnswers) => {
    setLoading(true);
    const respose = await post("/api/questions/", {
      question,
      noAnswers,
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
    await deleteAction("/api/questions/", id);
    setResults([]);
    setQuestions([]);
    setLoading(false);
  };

  const mapResultsToTable = () => {
    return (
      <>
        <hr />
        <Table celled>
          <Table.Header>
            <Table.Row>
              <Table.HeaderCell>ID</Table.HeaderCell>
              <Table.HeaderCell>Question</Table.HeaderCell>
              <Table.HeaderCell>Number of answers</Table.HeaderCell>
            </Table.Row>
            {results.map((r) => (
              <Table.Row key={r.id}>
                <Table.Cell>{r.id}</Table.Cell>
                <Table.Cell>{r.question}</Table.Cell>
                <Table.Cell>{r.noAnswers}</Table.Cell>
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
      <QuestionForm onSubmit={addQuestion} />
      <hr />
      <Segment color="blue">
        <Form onSubmit={submitForm}>
          <p>Search for question</p>
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
/*
* import React, { useState } from "react";
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
  const [questions, setQuestions] = useState([]);

  const submitForm = async () => {
    console.log(query);
    let baseUrl = "/api/questions/";
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
    setQuestions(jsonBody)
  };

  const addPerson = async (firstName, lastName) => {
    setLoading(true);
    const respose = await post("/api/questions/", {
      firstName,
      lastName,
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
    await deleteAction("/api/questions/", id);
    setResults([]);
    setQuestions([]);
    setLoading(false);
  };

  const mapResultsToTable = () => {
    return (
      <>
        <hr />
        <Table celled>
          <Table.Header>
            <Table.Row>
              <Table.HeaderCell>ID</Table.HeaderCell>
              <Table.HeaderCell>First name</Table.HeaderCell>
              <Table.HeaderCell>Last name</Table.HeaderCell>
            </Table.Row>
            {results.map((r) => (
              <Table.Row key={r.id}>
                <Table.Cell>{r.id}</Table.Cell>
                <Table.Cell>{r.firstName}</Table.Cell>
                <Table.Cell>{r.lastName}</Table.Cell>
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
*/