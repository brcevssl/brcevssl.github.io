import { render, screen } from '@testing-library/react';
import App from './App';

test('Pipeline', () => {
  render(<App />);
  const linkElement = screen.getByText('Employee');
  expect(linkElement).toBeInTheDocument();
});
