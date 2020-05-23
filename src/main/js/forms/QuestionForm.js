import React, { useState } from "react";
import { Segment, Form, Label, Button, Message } from "semantic-ui-react";

const successMessage = (
  <Message positive>
    <Message.Header>Creation successful</Message.Header>
    <p>The entity was successfully added to the DB.</p>
  </Message>
);

const QuestionForm = ({ onSubmit }) => {
  const [question, setQuestion] = useState("");
  const [noAnswers, setNoAnswers] = useState("");

  const [AnswerA, setAnswerA] = useState("");
  const [AnswerB, setAnswerB] = useState("");
  const [AnswerC, setAnswerC] = useState("");
  const [AnswerD, setAnswerD] = useState("");
  const [AnswerE, setAnswerE] = useState("");


  const [showSuccess, setShowSuccess] = useState(false);

  const submitPerson = async () => {
    if (question && noAnswers) {
      await onSubmit(question, noAnswers);
      setQuestion("");
      setNoAnswers("");

      setShowSuccess(true);
      setTimeout(() => {
        setShowSuccess(false);
      }, 5000);
    }
  };

  const handleQuestionChange = (e) => {
    setQuestion(e.target.value);
  };

  const handleNoAnswersChange = (e) => {
    setNoAnswers(e.target.value);
  };

  const handleAnswers = (e) => {

    let nam = e.target.name;
    let val = e.target.value;
    this.setState({[nam]: val});
  }

  const AnswersField = ({nr}) => {
    const names = [AnswerA, AnswerB, AnswerC, AnswerD, AnswerE];
    const allLetters = ["A", "B", "C", "D", "E"];

    return (
        <Form.Input
            placeholder={"Answer " + allLetters[nr]}
            name={names[nr]}
            onChange={handleAnswers}
        />
    );
  }

  const AnswersFields = ({noAnswers}) => {
    const num = [0,1,2,3,4,5]
    const iter =  num.slice(0, noAnswers);

    return iter.map(i => (
        <AnswersField nr={i} />
    ));
  }

  return (
    <Segment color="blue">
      {showSuccess && successMessage}
      <Form onSubmit={submitPerson}>
        <p>Add a question</p>
        <Label>Question</Label>
        <Form.Input
          placeholder="Ask..."
          value={question}
          onChange={handleQuestionChange}
        />
        <Label>Number of answers:</Label>
        <select value={noAnswers} onChange={handleNoAnswersChange}>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
        </select>
        <Label />
        <AnswersFields noAnswers={noAnswers} />
        <Button primary type="submit">
          Submit
        </Button>
      </Form>
    </Segment>
  );
};

export default QuestionForm;
