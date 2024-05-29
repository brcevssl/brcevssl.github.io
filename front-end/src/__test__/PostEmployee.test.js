import PostEmployee from '../pages/employee/PostEmployee';
import { render, screen } from "@testing-library/react";

test('Dashboard component text test', () => {
    render(<PostEmployee />);
    const specificText = screen.getByText('Post New Employee');
    expect(specificText).toBeInTheDocument();
  });
  