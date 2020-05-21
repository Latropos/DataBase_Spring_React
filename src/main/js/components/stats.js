import React from "react";
import { PieChart, Pie } from "recharts";
import { Segment, Header } from "semantic-ui-react";
const data01 = [
  {
    name: "A",
    value: 400,
  },
  {
    name: "B",
    value: 300,
  },
  {
    name: "C",
    value: 300,
  },
  {
    name: "D",
    value: 200,
  },
  {
    name: "E",
    value: 278,
  },
  {
    name: "F",
    value: 189,
  },
];
const data02 = [
  {
    name: "A",
    value: 2400,
  },
  {
    name: "B",
    value: 4567,
  },
  {
    name: "C",
    value: 1398,
  },
  {
    name: "D",
    value: 9800,
  },
  {
    name: "E",
    value: 3908,
  },
  {
    name: "F",
    value: 4800,
  },
];

let renderLabel = function(entry) {
  return entry.name;
}

const Stats = () => {
  return (
      <Segment>
        <Header as="h3">Statistics</Header>
        <hr />
        <PieChart width={730} height={250}>
          <Pie
              data={data01}
              dataKey="value"
              nameKey="name"
              cx="50%"
              cy="50%"
              outerRadius={50}
              fill="#8884d8"
          />
          <Pie
              data={data02}
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
  );
};


export default Stats;
