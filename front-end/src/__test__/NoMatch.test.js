import NoMatch from '../pages/noMatch/NoMatch';
import { render, screen } from "@testing-library/react";

test('NoMatch component text test', () => {
  render(<NoMatch />);
  const specificText = screen.getByText('404 Not Found');
  expect(specificText).toBeInTheDocument();
});