import Dashboard from "../pages/dashboard/Dashboard";
import { render, screen } from "@testing-library/react";
   
test('Dashboard component text test', () => {
      render(<Dashboard />);
      const specificText = screen.getByText('Dashboard Component');
      expect(specificText).toBeInTheDocument();
    });