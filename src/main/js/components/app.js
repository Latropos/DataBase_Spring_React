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
import { get, post, deleteAction, editAction } from "../apiService";
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

  const addQuestion = async (question, noAnswers, answerA, answerB, answerC, answerD, answerE) => {
    console.log("addQ");
    setLoading(true);
    const respose = await post("/api/questions/", {
      question,
      noAnswers,
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
    await deleteAction("/api/questions/", id);
    setResults([]);
    setLoading(false);
  };

  const incrementAnswer = async (id, letter) => {
    console.log("answering ",letter," ", id);
    setLoading(true);
    await editAction("/api/questions/", id, letter);
    setResults([]);
    setLoading(false);
  }

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
                  <>
                    <Table.Row key={r.id}>
                      <Table.Cell>{r.question}</Table.Cell>
                      <Table.Cell>{r.answerA}</Table.Cell>
                      <Table.Cell>{r.answerB}</Table.Cell>
                      <Table.Cell>{r.answerC}</Table.Cell>
                      <Table.Cell>{r.answerD}</Table.Cell>
                      <Table.Cell>{r.answerE}</Table.Cell>
                      <Table.Cell></Table.Cell>
                    </Table.Row>
                    <Table.Row>
                      <Table.Cell></Table.Cell>
                      <Table.Cell>

                        <Button color="blue" onClick={() => incrementAnswer(r.id, "a")}>
                          A [{r.aCount}]
                        </Button>
                      </Table.Cell>
                      <Table.Cell>
                        <Button color="blue" onClick={() => incrementAnswer(r.id, "b")}>
                          B [{r.bCount}]
                        </Button>
                      </Table.Cell>
                      <Table.Cell>
                        { r.noAnswers > 2 ?

                            <Button color="blue" onClick={() => incrementAnswer(r.id, "c")}>
                              C [{r.cCount}]
                            </Button>
                            :
                            <div></div>
                        }
                      </Table.Cell>
                      <Table.Cell>
                        { r.noAnswers > 3 ?

                            <Button color="blue" onClick={() => incrementAnswer(r.id, "d")}>
                              D [{r.dCount}]
                            </Button>
                            :
                            <div></div>
                        }
                      </Table.Cell>
                      <Table.Cell>
                        { r.noAnswers > 4 ?

                            <Button color="blue" onClick={() => incrementAnswer(r.id, "e")}>
                              E [{r.eCount}]
                            </Button>
                            :
                            <div></div>
                        }
                      </Table.Cell>
                      <Table.Cell>
                        <Button color="red" onClick={() => deleteById(r.id)}>
                          Delete
                        </Button>
                      </Table.Cell>
                    </Table.Row>
                  </>
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
      <Segment>
      {results && results.length > 0 && mapResultsToTable()}
      </Segment>
      {loading && (
          <Dimmer active inverted>
            <Loader inverted>Loading...</Loader>
          </Dimmer>
      )}
    </Container>
  );
};

export default App;