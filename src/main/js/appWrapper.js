import React from "react";
import { Container, Menu } from "semantic-ui-react";

import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import App from "./components/app";
import Stats from "./components/stats";

const AppWrapper = () => {
  return (
    <Container>
      <Router>
        <Menu>
          <Menu.Item as={Link} to="/">
            Main page
          </Menu.Item>

          <Menu.Item as={Link} to="/statistics">
            Statistics
          </Menu.Item>
        </Menu>
        <Container>
          <Switch>
            <Route exact path="/">
              <App />
            </Route>
            <Route exact path="/statistics">
              <Stats />
              <Stats />
            </Route>
          </Switch>
        </Container>
      </Router>
    </Container>
  );
};

export default AppWrapper;
