import React, {useState} from "react";
import { PieChart, Pie } from "recharts";
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
import {get} from "../apiService";

let renderLabel = function(entry) {
  return entry.name;
}

const Stats = () => {
  const [loading, setLoading] = useState(false);
  const [results, setResults] = useState([]);
  const [query, setQuery] = useState(0);


  const getData = async () => {
    setLoading(true);
    let baseUrl = "/api/questions/";
    const jsonBody = await get(baseUrl, null);
    let result = [
      {
        name: "A",
        value: jsonBody[query].aCount,
      },
      {
        name: "B",
        value: jsonBody[query].bCount,
      },
      {
        name: "C",
        value: jsonBody[query].cCount,
      },
      {
        name: "D",
        value: jsonBody[query].dCount,
      },
      {
        name: "E",
        value: jsonBody[query].eCount,
      },
    ];

    setResults(result);
    setLoading(false);
  }
  const getStat = () => {
    return
  }
  const handleInputChange = (e) => {
    setQuery(e.target.value);
  };
  const submitQuery = async () => {
    if (query) {
      setQuery(0);
    }
  };

  console.info(results);
  return (
      <Container>
        <Segment>
          <Header as="h3">Statistics</Header>
          <hr />
          <Form onSubmit={submitQuery}>
            <Form.Input
                placeholder="Search..."
                value={query}
                onChange={handleInputChange}
            />
          </Form>

          <Button color="blue" onClick={() => getData()}>
            Get statistics
          </Button>
          <PieChart width={730} height={250}>
            <Pie
                data={results}
                dataKey="value"
                nameKey="name"
                cx="50%"
                cy="50%"
                outerRadius={50}
                fill="#8884d8"
            />
            <Pie
                data={results}
                dataKey="value"
                nameKey="name"
                cx="50%"
                cy="50%"
                innerRadius={60}
                outerRadius={80}
                fill="#82ca9d"
                label={renderLabel}
            />
          </PieChart>
        </Segment>
        {loading && (
            <Dimmer active inverted>
              <Loader inverted>Loading...</Loader>
            </Dimmer>
        )}
      </Container>
  );
};

export default Stats;