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
var data01 = [
  {
    name: "AA",
    value: 100,
  },
  {
    name: "B",
    value: 100,
  },
  {
    name: "C",
    value: 100,
  },
  {
    name: "D",
    value: 100,
  },
  {
    name: "E",
    value: 100,
  },
];

let renderLabel = function(entry) {
  return entry.name;
}

const Stats = () => {
  const [loading, setLoading] = useState(false);
  const [results, setResults] = useState([]);
  const getData = async () => {
    setLoading(true);
    let baseUrl = "/api/questions/";
    const jsonBody = await get(baseUrl, null);
    let result = [
      {
        name: "A",
        value: jsonBody[0].aCount,
      },
      {
        name: "B",
        value: jsonBody[0].bCount,
      },
      {
        name: "C",
        value: jsonBody[0].cCount,
      },
      {
        name: "D",
        value: jsonBody[0].dCount,
      },
      {
        name: "E",
        value: jsonBody[0].eCount,
      },
    ];
    setResults(result);
    setLoading(false);
  }
  const getStat = () => {
    return
  }
  console.info(results);
  return (
      <Container>
        <Segment>
          <Header as="h3">Statistics</Header>
          <hr />
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