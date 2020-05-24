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
  const [noAnswers, setNoAnswers] = useState(2);

  const [answerA, setAnswerA] = useState("");
  const [answerB, setAnswerB] = useState("");
  const [answerC, setAnswerC] = useState("");
  const [answerD, setAnswerD] = useState("");
  const [answerE, setAnswerE] = useState("");


  const [showSuccess, setShowSuccess] = useState(false);

  const submitQuestion = async () => {
    if (question && noAnswers) {
      await onSubmit(question, noAnswers, answerA, answerB, answerC, answerD, answerE);
      setQuestion("");
      setNoAnswers(2);

      setAnswerA("");
      setAnswerB("");
      setAnswerC("");
      setAnswerD("");
      setAnswerE("");

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

  const handleAnswerAChange = (e) => {
    setAnswerA(e.target.value);
  }
  const handleAnswerBChange = (e) => {
    setAnswerB(e.target.value);
  }
  const handleAnswerCChange = (e) => {
    setAnswerC(e.target.value);
  }
  const handleAnswerDChange = (e) => {
    setAnswerD(e.target.value);
  }
  const handleAnswerEChange = (e) => {
    setAnswerE(e.target.value);
  }

  return (
    <Segment color="blue">
      {showSuccess && successMessage}
      <Form onSubmit={submitQuestion}>
        <p>Add a question</p>
        <Label>Question</Label>
        <Form.Input
          placeholder="Ask..."
          value={question}
          onChange={handleQuestionChange}
        />
        <Label>Number of answers:</Label>
        <select value={noAnswers} onChange={handleNoAnswersChange}>
          <option value={2}>2</option>
          <option value={3}>3</option>
          <option value={4}>4</option>
          <option value={5}>5</option>
        </select>
        <Label /><Form.Input
          placeholder="Answer A"
          value={answerA}
          onChange={handleAnswerAChange}
      />
        <Form.Input
            placeholder="Answer B"
            value={answerB}
            onChange={handleAnswerBChange}
        />
        { noAnswers>2 ?
            <Form.Input
                placeholder="Answer C"
                value={answerC}
                onChange={handleAnswerCChange}
            />
            :
            <div></div>
        }
        { noAnswers>3 ?
            <Form.Input
                placeholder="Answer D"
                value={answerD}
                onChange={handleAnswerDChange}
            />
            :
            <div></div>
        }
        { noAnswers>4 ?
            <Form.Input
                placeholder="Answer E"
                value={answerE}
                onChange={handleAnswerEChange}
            />
            :
            <div></div>
        }

        <Button primary type="submit">
          Submit
        </Button>
      </Form>
    </Segment>
  );
};

export default QuestionForm;