import Header from '../pages/header/Header';
import BasicRouter from '../pages/basicRouter/BasicRouter';
import { render, screen } from "@testing-library/react";

  test('Header component text test', () => {
  render(<BasicRouter><Header /></BasicRouter>);
  const specificText = screen.getByText('Employee Management System');
  expect(specificText).toBeInTheDocument();
});